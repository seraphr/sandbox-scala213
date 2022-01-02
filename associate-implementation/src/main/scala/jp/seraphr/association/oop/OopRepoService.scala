package jp.seraphr.association.oop

import jp.seraphr.association.common.{ RepoService, Repository }

class OopRepoService(copier: Copier) extends RepoService {

  private val templateStorage = copier.templateStorage
  private val repoStorage     = copier.repoStorage

  override def createNewRepo(templateId: String, newRepoId: String): Repository = {
    println(s"create new repo from template ${templateId}")
    if (templateStorage.get(templateId).isEmpty) {
      throw new RuntimeException(s"not found template: ${templateId}")
    }
    copier.copy(templateId, newRepoId)
    val tResult =
      repoStorage.get(newRepoId).getOrElse(throw new RuntimeException(s"not found new repository: ${newRepoId}"))
    println(s"created: ${newRepoId}")
    tResult
  }
}
