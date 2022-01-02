package jp.seraphr.association.common

trait RepoService {
  def createNewRepo(templateId: String, newRepoId: String): Unit
}
