package tic;

public class JingziQi {

static   final   int   INFINITY = 100 ;   // ��ʾ�����ֵ
static   final   int   WIN = +INFINITY ;   // MAX���������Ϊ������
static   final   int   LOSE = -INFINITY ;   // MAX����С���棨��MIN�������棩Ϊ������
static   final   int   DOUBLE_LINK = INFINITY / 2 ;   // ���ͬһ�С��л�Խ�������������������
static   final   int   INPROGRESS = 1 ;   // �Կɼ����£�û��ʤ����;֣�
static   final   int   DRAW = 0 ;   // �;�
static   final   int [][] WIN_STATUS =   {
      { 0, 1, 2 },
      { 3, 4, 5 },
      { 6, 7, 8 },
      { 0, 3, 6 },
      { 1, 4, 7 },
      { 2, 5, 8 },
      { 0, 4, 8 },
      { 2, 4, 6   }
};
/**
 * ��ֵ�������ṩһ������ʽ��ֵ����������ϷAI�ĸߵ�
 */
public  static int    gameState( char []   board )   {
       int   result = INPROGRESS;
       boolean   isFull =   true ;
      
       // is game over?
       for   ( int   pos = 0; pos < 9; pos++) {
             char   chess = board[pos];
             if   ( String.valueOf(chess).isEmpty()) {
                  isFull =   false ;
                   break ;
            }
      }
       // is Max win/lose?
       for   ( int [] status : WIN_STATUS) {
             char   chess = board[status[0]];
             if   (String.valueOf(chess).isEmpty() ) {
                   break ;
            }
             int   i = 1;
             for   (; i < status.length; i++) {
                   if   (board[status[i]] != chess) {
                         break ;
                  }
            }
             if   (i == status.length) {
                  result = chess == 'x' ? WIN : LOSE;
                   break ;
            }
      }
       if   (result != WIN & result != LOSE) {
             if   (isFull) {
                   // is draw
                  result = DRAW;
            }   else   {
                   // check double link
                   // finds[0]->'x', finds[1]->'o'
                   int [] finds =   new   int [2];
                   for   ( int [] status : WIN_STATUS) {
                        
						char   chess = 0 ;
                         boolean   hasEmpty =   false ;
                         int   count = 0;
                         for   ( int   i = 0; i < status.length; i++) {
                               if   (String.valueOf(board[status[i]]).isEmpty() ) {
                                    hasEmpty =   true ;
                              }   else   {
                                     if   (String.valueOf(chess).isEmpty() ) {
                                          chess = board[status[i]];
                                    }
                                     if   (board[status[i]] == chess) {
                                          count++;
                                    }
                              }
                        }
                         if   (hasEmpty && count > 1) {
                               if   (chess ==   'x' ) {
                                    finds[0]++;
                              }   else   {
                                    finds[1]++;
                              }
                        }
                  }
                   // check if two in one line
                   if   (finds[1] > 0) {
                        result = -DOUBLE_LINK;
                  }   else   if   (finds[0] > 0) {
                        result = DOUBLE_LINK;
                  }
            }
      }
       return   result;
}
    public static boolean isWin(char []board) {
    	 boolean flag=false;
    	 for   ( int [] status : WIN_STATUS) {
    		 char   chess = board[status[0]];
    	        if   (String.valueOf(chess).isEmpty() ) {
                    break ;
             }
              int   i = 1;
              for   (; i < status.length; i++) {
                    if   (board[status[i]] != chess) {
                          break;
                   }
                    else if(chess=='x') {
                    	System.out.println("201621123075Ӯ��");
                    	flag=true;
                    }
                    else if(chess=='o') {
                    	System.out.println("AIӮ��");
                    	flag=true;
                    }
               
             }
    	 }return flag;
    }
    public static void main(String[] args) {
		char[] board=new char[9];
		System.out.println(gameState(board));
		board[2]='x';
		board[3]='o';
		System.out.println(gameState(board));
	}
}
