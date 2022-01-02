# 問題設定

このプロジェクトでは、以下の問題を解決する実装を作成する。


* 前提
    * githubのリポジトリテンプレートのように、リポジトリをテンプレートプロジェクトから生成するような問題を想定する
    * ユーザの操作によって以下のような動作を行う
        * ユーザによってテンプレートのIDをと新しいリポジトリのIDが指定される
        * テンプレート用のストレージからリポジトリ用のストレージにデータをコピーする
        * コピー先には、ユーザが指定した新しいIDとしてコピーを行う
* 問題
    * ストレージの実装により、効率的なコピー方法が異なる場合があり最適な方法を選びたい
        * 例えば、メモリ実装はメモリ上でのコピーが最適だが、ファイルシステム実装は直接ファイルをコピーしたほうが良い
    * 新規リポジトリの作成はコピー以外にもやることがある（という想定な）ので、ストレージ実装の種類に依らず、共通の動作は一つの実装でまかないたい
    * コピーを行う場合、不正な組み合わせ（テンプレートのメモリ実装 vs リポジトリのファイルシステム実装 など）では利用できないように（コンパイル自体が出来ないようにしたい）
    