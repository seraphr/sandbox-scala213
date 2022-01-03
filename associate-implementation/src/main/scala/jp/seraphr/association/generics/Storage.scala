package jp.seraphr.association.generics

import jp.seraphr.association.common

trait Storage[Path] extends common.Storage {
  def getPath(id: String): Path
  def copyFrom(newId: String, path: Path): Unit
}

trait RepositoryStorage[Path] extends Storage[Path] with common.RepositoryStorage
trait TemplateStorage[Path]   extends Storage[Path] with common.TemplateStorage
