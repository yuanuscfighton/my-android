package com.laioffer.my_mvx.demo3_mvp.view;

public interface IGameView {

  void showWinner(String winningPlayerDisplayLabel);

  void clearWinnerDisplay();

  void clearButtons();

  void setButtonText(int row, int col, String text);
}
