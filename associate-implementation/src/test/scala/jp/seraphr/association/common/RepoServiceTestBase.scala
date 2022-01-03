package jp.seraphr.association.common

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

trait RepoServiceTestBase extends AnyFreeSpecLike with Matchers {
  protected def createMemoryObjects(): (RepoService, TemplateStorage, RepositoryStorage)
  protected def createFileObjects(): (RepoService, TemplateStorage, RepositoryStorage)

  private def runServiceTest(service: RepoService, tempStorage: TemplateStorage, repoStorage: RepositoryStorage): Unit = {
    tempStorage.add(Repository("temp1", RepositoryData("test description")))
    val tCreated = service.createNewRepo("temp1", "repo1")

    tCreated shouldBe Repository("repo1", RepositoryData("test description"))
    repoStorage.get("repo1").get shouldBe tCreated
  }

  "メモリ実装テスト" in {
    (runServiceTest _).tupled(createMemoryObjects())
  }

  "ファイル実装テスト" in {
    (runServiceTest _).tupled(createFileObjects())
  }
}
