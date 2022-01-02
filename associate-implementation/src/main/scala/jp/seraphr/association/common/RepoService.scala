package jp.seraphr.association.common

trait RepoService {

  /**
   * @param templateId
   * @param newRepoId
   * @return 作成したRepository
   */
  def createNewRepo(templateId: String, newRepoId: String): Repository
}
