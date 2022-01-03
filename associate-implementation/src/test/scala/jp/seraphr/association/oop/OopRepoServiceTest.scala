package jp.seraphr.association.oop

import jp.seraphr.association.common.{ RepoService, RepoServiceTestBase, RepositoryStorage, TemplateStorage }

class OopRepoServiceTest extends RepoServiceTestBase {
  override protected def createMemoryObjects(): (RepoService, TemplateStorage, RepositoryStorage) = {
    val tTempStorage = new MemoryTemplateStorage
    val tRepoStorage = new MemoryRepositoryStorage
    val tService     = new OopRepoService(new MemoryCopier(tTempStorage, tRepoStorage))

    (tService, tTempStorage, tRepoStorage)
  }

  override protected def createFileObjects(): (RepoService, TemplateStorage, RepositoryStorage) = {
    val tUnderlying  = new MemoryStorage {}
    val tTempStorage = new FileTemplateStorage(tUnderlying)
    val tRepoStorage = new FileRepositoryStorage(tUnderlying)
    val tService     = new OopRepoService(new FileCopier(tTempStorage, tRepoStorage))

    (tService, tTempStorage, tRepoStorage)
  }
}
