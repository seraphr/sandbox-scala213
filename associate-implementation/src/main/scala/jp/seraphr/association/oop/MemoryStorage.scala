package jp.seraphr.association.oop

import jp.seraphr.association.common

trait MemoryStorage extends common.MemoryStorage

trait MemoryRepositoryStorage extends MemoryStorage with common.MemoryRepositoryStorage
trait MemoryTemplateStorage   extends MemoryStorage with common.MemoryTemplateStorage
