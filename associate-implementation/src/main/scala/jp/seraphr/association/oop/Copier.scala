package jp.seraphr.association.oop

import jp.seraphr.association.common.{ RepositoryStorage, TemplateStorage }

trait Copier {
  val templateStorage: TemplateStorage
  val repoStorage: RepositoryStorage
  def copy(templateId: String, repoId: String): Unit
}

class FileCopier(val templateStorage: FileTemplateStorage, val repoStorage: FileRepositoryStorage) extends Copier {
  override def copy(templateId: String, repoId: String): Unit = {
    val tPath = templateStorage.getPath(templateId)
    repoStorage.copyFrom(repoId, tPath)
  }
}

class MemoryCopier(val templateStorage: MemoryTemplateStorage, val repoStorage: MemoryRepositoryStorage)
    extends Copier {
  override def copy(templateId: String, repoId: String): Unit = {
    val tRepo = templateStorage.get(templateId).getOrElse(throw new RuntimeException(s"not found: ${templateId}"))
    repoStorage.add(tRepo.copy(id = repoId))
  }
}
