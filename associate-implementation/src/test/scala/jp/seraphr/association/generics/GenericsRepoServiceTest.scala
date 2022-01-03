package jp.seraphr.association.generics

import jp.seraphr.association.common
import jp.seraphr.association.common.{ RepoService, RepoServiceTestBase }

class GenericsRepoServiceTest extends RepoServiceTestBase {
  override protected def createMemoryObjects(): (RepoService, common.TemplateStorage, common.RepositoryStorage) = {
    val tTempStorage = new MemoryTemplateStorage
    val tRepoStorage = new MemoryRepositoryStorage
    val tService     = new GenericsRepoService(tTempStorage, tRepoStorage)

    (tService, tTempStorage, tRepoStorage)
  }

  override protected def createFileObjects(): (RepoService, common.TemplateStorage, common.RepositoryStorage) = {
    val tUnderlying  = new MemoryStorage {}
    val tTempStorage = new FileTemplateStorage(tUnderlying)
    val tRepoStorage = new FileRepositoryStorage(tUnderlying)
    val tService     = new GenericsRepoService(tTempStorage, tRepoStorage)

    (tService, tTempStorage, tRepoStorage)
  }
}
