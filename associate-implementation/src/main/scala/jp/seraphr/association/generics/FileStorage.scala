package jp.seraphr.association.generics

import jp.seraphr.association.common

case class FilePath(path: String)
trait FileStorage extends Storage[FilePath] with common.FileStorage {
  def getPath(repoId: String): FilePath = {
    FilePath(encodeId(repoId))
  }
  def copyFrom(newId: String, path: FilePath): Unit = {
    val tFrom = mUnderlying.get(path.path).getOrElse(throw new RuntimeException(s"not found: ${path}"))
    this.add(tFrom.copy(id = newId))
  }
}

class FileRepositoryStorage(val mUnderlying: common.MemoryStorage)
    extends RepositoryStorage[FilePath]
    with FileStorage
    with common.FileRepositoryStorage
class FileTemplateStorage(val mUnderlying: common.MemoryStorage)
    extends TemplateStorage[FilePath]
    with FileStorage
    with common.FileTemplateStorage
