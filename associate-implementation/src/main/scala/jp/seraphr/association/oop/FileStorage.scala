package jp.seraphr.association.oop

import jp.seraphr.association.common

case class FilePath(path: String)

trait FileStorage extends common.FileStorage {
  def getPath(repoId: String): FilePath = {
    FilePath(encodeId(repoId))
  }
  def copyFrom(newId: String, path: FilePath): Unit = {
    val tFrom = mUnderlying.get(path.path).getOrElse(throw new RuntimeException(s"not found: ${path}"))
    this.add(tFrom.copy(id = newId))
  }
}

class FileRepositoryStorage(val mUnderlying: common.MemoryStorage) extends common.FileRepositoryStorage with FileStorage {}
class FileTemplateStorage(val mUnderlying: common.MemoryStorage) extends common.FileTemplateStorage with FileStorage
