package jp.seraphr.association.common

trait FileStorage extends Storage {
  // 実際にファイルに保存されていることは本質じゃないので、メモリに保存しておく
  protected val mUnderlying: MemoryStorage
  protected val prefix: String
  protected def encodeId(id: String): String = s"${prefix}.${id}"
  protected def decodeId(id: String): String = id.substring(prefix.length + 1)

  implicit class RepoOps(r: Repository) {
    def encode: Repository = r.copy(id = encodeId(r.id))
    def decode: Repository = r.copy(id = decodeId(r.id))
  }

  override def add(repo: Repository): Unit             = mUnderlying.add(repo.encode)
  override def get(repoId: String): Option[Repository] = mUnderlying.get(encodeId(repoId)).map(_.decode)
  override def all: Seq[Repository]                    = mUnderlying.all.map(_.decode)
}

trait FileRepositoryStorage extends RepositoryStorage with FileStorage {
  override protected val prefix: String = "repository"
}
trait FileTemplateStorage extends TemplateStorage with FileStorage {
  override protected val prefix: String = "template"
}
