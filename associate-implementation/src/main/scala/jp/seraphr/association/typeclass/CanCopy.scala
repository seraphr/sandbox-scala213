package jp.seraphr.association.typeclass

trait CanCopy[TS, RS] {
  def copy(templateStorage: TS, repositoryStorage: RS, templatId: String, repoId: String): Unit
}

object CanCopy {
  private val genericSamePathCanCopy = new CanCopy[TemplateStorage[Any], RepositoryStorage[Any]] {
    override def copy(
        templateStorage: TemplateStorage[Any],
        repositoryStorage: RepositoryStorage[Any],
        templateId: String,
        repoId: String
    ): Unit = {
      val tPath = templateStorage.getPath(templateId)
      repositoryStorage.copyFrom(repoId, tPath)
    }
  }

  implicit def samePathCanCopy[Path, TS, RS](implicit
      ev1: TS <:< TemplateStorage[Path],
      ev2: RS <:< RepositoryStorage[Path]
  ): CanCopy[TS, RS] =
    genericSamePathCanCopy.asInstanceOf[CanCopy[TS, RS]]
}
