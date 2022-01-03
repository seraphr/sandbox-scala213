package jp.seraphr.association

import jp.seraphr.association.generics

/**
 * CanCopyという型クラスを定義し、そのインスタンスが提供されることでコピーが可能であることを証明する。
 * 不正な組み合わせでは、型クラスインスタンスを提供せず、コンパイルエラーとすることでストレージ間の関係を保証する
 *
 * * pros
 *     * 型クラスによる高い柔軟性を得ることが出来る
 *         * 現行の実装ではgenericsの実装と同じくPathの型が一致してることを条件としているが、型クラスインスタンスの提供方法を変えることで、自由にこれを変えることが出来る
 *         * oopのように、特定のクラス間でのみコンパイルを通すようにすることも可能
 *     * implicitによる暗黙的な引数の受け渡し・型クラスインスタンス導出により、ボイラプレートなコードを削減できる
 * * cons
 *     * 型クラスについての理解が必要
 *         * implicitは型クラスをエミュレートするための言語機能だが、それ自体が型クラスを表現するわけでは無い
 *     * implicitにどのインスタンスが渡されているのか、追いかけるのが大変
 *         * 意図しない型クラスインスタンスが渡されてしまったりした時に追いかけるのが地味に大変
 *         * 型クラスインスタンスの導出・探索がどのように行われるかについてscala compilerの挙動の知識が必要になる
 *             * わかってないと、意図しない動作したときのデバッグが大変
 */
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
