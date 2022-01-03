package jp.seraphr.association.typeclass

import jp.seraphr.association.common.{ RepoService, Repository }

class TypeClassRepoService[TS <: TemplateStorage[_], RS <: RepositoryStorage[_]](
    templateStorage: TS,
    repositoryStorage: RS
)(implicit
    canCopy: CanCopy[TS, RS]
) extends RepoService {

  /**
   * @param templateId
   * @param newRepoId
   * @return 作成したRepository
   */
  override def createNewRepo(templateId: String, newRepoId: String): Repository = {
    println(s"create new repo from template ${templateId}")
    if (templateStorage.get(templateId).isEmpty) {
      throw new RuntimeException(s"not found template: ${templateId}")
    }

    canCopy.copy(templateStorage, repositoryStorage, templateId, newRepoId)
    println(s"created: ${newRepoId}")
    repositoryStorage.get(newRepoId).get
  }
}
