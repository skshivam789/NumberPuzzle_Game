import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		swapButton(buttons[emptyCellId],buttonClicked);
		int n = buttons.length;
		for (int i=0;i<n;i++) {
			if (buttons[i].getLabel()=="  ")
				emptyCellId=i;
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		 for (int i=0;i<15;i++){
	            int x = 0;
	            while(x==0){
	                int a = getRandomNumber(); 
	                int b = a%15+1;
	                int y= 1;
	                for (int j=0;j<i;j++){
	                    if (arr[j]==b)
	                    {  y = 0;
	                        break;}
	                }
	                if (y==1){
	                    arr[i] = b;
	                    x = 1;}
	            }	         
	            }
				
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr = getIntegerArrayOfButtonIds(buttons);
		for (int i=0;i<15;i++) {
			if (arr[i]==i+1){
				continue;
			}
			else {
				winner = false;
				break;
			}
		}

		return winner;
	}
}
