package jp.seraphr.association

/**
 * StorageにPathという抽象データ型を型引数として持たせて、その実際の型が一致していることをもって、コピーが可能であることを証明する。
 * 型が一致していなければコンパイルエラーとすることで、ストレージ間の関係を保証する。
 *
 * * pros
 *     * 型引数さえ理解していればわかりやすい
 * * cons
 *     * 複雑化すると、大量の型引数を書かないと行けなくて手間
 *     * 型の一致のみで『可能である』ことにしているので、その点について柔軟性が無い
 *         * Pathの型をStringなどの一般的な型にしてしまうと制約に意味がなくなる
 *         * S3実装ができて、File実装とS3実装間でコピーが出来るようにしようと思うと、File実装のPathの型をあとから変える必要がある
 */
package object generics
