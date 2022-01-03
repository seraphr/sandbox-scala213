package jp.seraphr.association.generics

import jp.seraphr.association.common.{ RepoService, Repository }

class GenericsRepoService[Path](
    templateStorage: TemplateStorage[Path],
    repositoryStorage: RepositoryStorage[Path]
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

    val tPath = templateStorage.getPath(templateId)
    repositoryStorage.copyFrom(newRepoId, tPath)
    println(s"created: ${newRepoId}")
    repositoryStorage.get(newRepoId).get
  }
}
