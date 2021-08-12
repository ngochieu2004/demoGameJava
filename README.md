# demoGameJava

This is a basic caro game 1 player with an account system stored in a database in SQL.
The player plays against the computer with the minimax algorithm installed.

Installation Instructions:
  1. You must run file "caroUser.sql" by SQL Server Management Studio or Azure data studio with SQL container on Docker to init database
  2. Open source code on JAVA IDE (NetBeans) and go to Source packages/dataprovider/SQLServerDataProvider
  3. at the 20th line of the file, change:
                    strServer to your server name
                    strUsername to your database username
                    strPassword to your database password
  this change help the application connect and work with the database on your computer
  4.To run game, go to Source packages/GUI/MainMDI.java
  5.Use the default account to connect: username: test1 
                                        password: 123456
  
  The game is in the process of being completed, so the graphical interface is not really good, and there are still a few minor bugs that have not been optimized.
  I will try to improve the game.
  If you find a big error or have additional suggestions, please email tranngochieu97@gmail.com
  Thank you for reading!
