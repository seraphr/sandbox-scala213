package jp.seraphr.association

import jp.seraphr.association.generics

package object typeclass {
  // Storageの実装は、genericsのモノをそのまま使う
  type RepositoryStorage[Path] = generics.RepositoryStorage[Path]
  type TemplateStorage[Path]   = generics.TemplateStorage[Path]

  type FileRepositoryStorage   = generics.FileRepositoryStorage
  type FileTemplateStorage     = generics.FileTemplateStorage
  type MemoryRepositoryStorage = generics.MemoryRepositoryStorage
  type MemoryTemplateStorage   = generics.MemoryTemplateStorage

  val FilePath = generics.FilePath
  type FilePath = generics.FilePath

  val MemoryPath = generics.MemoryPath
  type MemoryPath = generics.MemoryPath
}
