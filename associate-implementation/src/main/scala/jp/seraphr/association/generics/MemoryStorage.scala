package jp.seraphr.association.generics

import jp.seraphr.association.common
import jp.seraphr.association.common.Repository

case class MemoryPath(data: Repository)
trait MemoryStorage extends Storage[MemoryPath] with common.MemoryStorage {
  override def getPath(id: String): MemoryPath = {
    val tRepo = this.get(id).getOrElse(throw new RuntimeException(s"not found: ${id}"))
    MemoryPath(tRepo)
  }
  override def copyFrom(newId: String, path: MemoryPath): Unit = {
    this.add(path.data.copy(id = newId))
  }
}

class MemoryRepositoryStorage
    extends RepositoryStorage[MemoryPath]
    with MemoryStorage
    with common.MemoryRepositoryStorage
class MemoryTemplateStorage extends TemplateStorage[MemoryPath] with MemoryStorage with common.MemoryTemplateStorage
