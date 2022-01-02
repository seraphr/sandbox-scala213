package jp.seraphr.association.common

case class Repository(
    id: String,
    data: RepositoryData
)

case class RepositoryData(
    description: String
)
