package jp.seraphr.association

/**
 * [[Copier]]のインスタンスが存在することがストレージ間のコピーが可能であることを証明する。
 * 不正なStorageの組み合わせでは[[Copier]]の実装classを作らないことで、ストレージ間の関係を保証する。
 *
 * * pros
 *     * Genericsさえも不要で実装間の連携を表明できる
 *     * 利用する言語機能の数が少なく、わかりやすい
 * * cons
 *     * 『効率的にコピー可能なストレージの組み合わせ』が複雑化すると、大量の[[Copier]]を実装する必要が出てくる
 *     * 例えば、S3実装が出来て、File実装とS3実装間は効率的にコピーが出来る場合以下の4種類の[[Copier]]実装が必要になる
 *         * File vs File
 *         * File vs S3
 *         * S3 vs File
 *         * S3 vs S3
 */
package object oop
