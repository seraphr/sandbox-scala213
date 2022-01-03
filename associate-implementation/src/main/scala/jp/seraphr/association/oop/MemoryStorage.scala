package jp.seraphr.association.oop

import jp.seraphr.association.common

trait MemoryStorage extends common.MemoryStorage

class MemoryRepositoryStorage extends MemoryStorage with common.MemoryRepositoryStorage
class MemoryTemplateStorage   extends MemoryStorage with common.MemoryTemplateStorage
