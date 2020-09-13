# 《Test-Driven Java Development》Book code
## Introduction
本项目是[《Java测试驱动开发》](https://www.ituring.com.cn/book/1942) 一书中实操的代码.

## 第 3 章　红灯-绿灯-重构——从失败到成功再到完美 

需求：
“井字游戏”的需求

“井字游戏”是两个人使用纸和铅笔玩的一种游戏，双方轮流在一个3×3
的网格中画X和O，最先在水平、垂直或对角线上将自己的3个标记连起来的玩
家获胜。
有关这款游戏的更详细信息，请参阅维基百科（http://en.wikipedia.org/ 
wiki/Tic-tac-toe）

### 需求 1
我们应该首先定义边界，以及将棋子放在哪些地方非法。
可将棋子放在3×3棋盘上任何没有棋子的地方。
可将这个需求分成三个测试：
- 如果棋子放在超出了X轴边界的地方，就引发RuntimeException异常；
- 如果棋子放在超出了Y轴边界的地方，就引发RuntimeException异常；
- 如果棋子放在已经有棋子的地方，就引发RuntimeException异常。

### 需求 2
现在处理轮到哪个玩家落子的问题。
需要提供一种途径，用于判断接下来该谁落子。可将这个需求分成三个测试：
- 玩家X先下；
- 如果上一次是X下的，接下来将轮到O下；
- 如果上一次是O下的，接下来将轮到X下。

### 需求 3
现在考虑这个游戏的获胜规则。我们必须检查所有可能获胜的情况，只要满足其中一个，就宣布相应玩家获胜
最先在水平、垂直或对角线上将自己的3个标记连起来的玩家获胜。

要检查同一玩家的3颗棋子是否连成了线，需要检查水平方向、垂直方向和对角线。

### 需求 4
现在缺失的唯一一项内容是如何处理平局。所有格子都占满则为平局。