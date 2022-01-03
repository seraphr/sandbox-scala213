package jp.seraphr.association.common

trait Storage {
  def add(repo: Repository): Unit
  def get(repoId: String): Option[Repository]
  def all: Seq[Repository]
}

trait RepositoryStorage extends Storage
trait TemplateStorage   extends Storage
