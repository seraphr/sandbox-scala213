package jp.seraphr.association.common

import scala.collection.mutable

trait MemoryStorage extends Storage {
  private val mRepos = mutable.Map[String, Repository]()

  override def add(repo: Repository): Unit = {
    if (mRepos.contains(repo.id)) {
      throw new RuntimeException(s"id重複: ${repo.id}")
    }
    mRepos(repo.id) = repo
  }

  override def get(repoId: String): Option[Repository] = mRepos.get(repoId)
  override def all: Seq[Repository]                    = mRepos.values.toSeq
}

trait MemoryRepositoryStorage extends MemoryStorage
trait MemoryTemplateStorage   extends MemoryStorage
