package jp.seraphr.association.typeclass

import jp.seraphr.association.common
import jp.seraphr.association.common.{ MemoryStorage, RepoService, RepoServiceTestBase }

class TypeClassRepoServiceTest extends RepoServiceTestBase {
  override protected def createMemoryObjects(): (RepoService, common.TemplateStorage, common.RepositoryStorage) = {
    val tTempStorage = new MemoryTemplateStorage
    val tRepoStorage = new MemoryRepositoryStorage
    val tService     = new TypeClassRepoService(tTempStorage, tRepoStorage)

    (tService, tTempStorage, tRepoStorage)
  }

  override protected def createFileObjects(): (RepoService, common.TemplateStorage, common.RepositoryStorage) = {
    val tUnderlying  = new MemoryStorage {}
    val tTempStorage = new FileTemplateStorage(tUnderlying)
    val tRepoStorage = new FileRepositoryStorage(tUnderlying)
    val tService     = new TypeClassRepoService(tTempStorage, tRepoStorage)

    (tService, tTempStorage, tRepoStorage)
  }
}
