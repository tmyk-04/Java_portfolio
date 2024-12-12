# 災害管理システム – Java Portfolio

<h4>はじめに</h4>
職業訓練校でHTML,CSS,PHPなどを学んできました。さらなる知識向上のため、独学でjavaを学びました。様々な言語を学ぶ中で特にjavaの持つオブジェクト指向の特性に興味を持ち、javaを用いてポートフォリオを作成しました。

<h4>開発目的</h4>
2024年に宮崎県で発生した震度6の地震を契機に、防災意識向上のため本システムを開発しました。
また、将来的に南海トラフ地震が発生する可能性が示唆されていることから、今後も機能の追加や修正を行う予定です。<br>

<h4>概要</h4>
このシステムは災害発生時に迅速に最寄りの避難所を検索・案内するための避難所管理システムです。
宮崎市のオープンデータを利用し、JavaとMySQLで構築されたWebアプリケーションとして動作します。
本システムの開発を通じて、Javaでのバックエンド処理とデータベースの知識向上を目的としています。

<h4>制作期間</h4>
約1か月半

<h4>開発環境</h4>
<ul>
  <li>プログラミング言語: Java</li>
  <li>データベース: AWS RDS(MySQL)</li>
  <li>サーバー: AWS EC2 (Linux) 上で Apache Tomcat を利用</li>
  <li>データベース接続: JDBC</li>
  <li>API : NominatimAPI(座標を取得するAPI)</li>
  <li>使用データ: 宮崎市オープンデータ(避難所情報)</li>
</ul>

<h4>システムの機能</h4>
本システムは、以下の機能を提供します<br>

<h5>1.避難所検索機能</h5>
<ul>
    <li>住所を入力</li>
    <li>NominatimAPIを用い、入力された住所から緯度経度を取得</li>
    <li>NominatimAPIから取得した緯度経度とデータベースの避難所の緯度経度を比較し最短距離順に並び変える</li>
    <li>最短距離順の避難所を３件まで表示</li>
</ul>
<h5>2.管理者機能</h5>
<ul>
    <li>管理者機能は現在実装中で、データベースの追加・更新・削除が可能となる予定です。</li>
</ul>

<h4>改善点</h4>
住所検索の精度が低い点が課題です。この課題を解決するため、他のAPIの使用や処理ロジックの見直しを検討します。

<h4>今後の拡張性</h4>
現在はリクエストに応じた検索と結果の表示を行うシンプルな構造ですが、避難所混雑状況の表示、マップを用いた避難経路の可視化等を検討しています。<br>
また、管理者機能を完成させ、データベースを操作できるよう実装します。





<!-- <h4>コメント</h4>
<ul>
  <li>add: 新しい機能やファイルを追加したとき。</li>
  <li>fix: バグ修正をしたとき。</li>
  <li>update: 機能を改良したり、既存のものを変更したとき。</li>
  <li>remove: 不要なコードや機能を削除したとき。</li>
  <li>refactor: コードのリファクタリングをしたとき（動作に変化はない）。</li>
  <li>docs: ドキュメント（READMEなど）を変更したとき。</li>
  <li>test: テストコードを追加・修正したとき。</li>
</ul> -->