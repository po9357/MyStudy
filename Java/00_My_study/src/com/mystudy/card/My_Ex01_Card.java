package com.mystudy.card;

import java.util.Scanner;

public class My_Ex01_Card {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Card temp;
		int player = 0;
		int com = 0;
		System.out.println("카드를 섞고 있습니다.");
		Deck d = new Deck();
		Card c = new Card();
		d.shuffle();
		
		System.out.println("플레이어1에게 카드를 5장 나누어줍니다.");
		d.pickCardMe();
		
		System.out.println("com에게 카드를 5장 나누어줍니다.");
		
		System.out.println(">>> com의 공개된 카드 3장");
		d.pickCardCom();
		
		boolean changeCard = true;
		while (changeCard) {
			System.out.println("바꾸고 싶은 카드를 입력하여 주십시오. (순서대로 1 ~ 5, 바꾸고 싶은 카드가 없다면 0)");
			int changeNum = sc.nextInt();
				if(changeNum>=1 && changeNum<=5) {		//다음 드로우 할 카드와 선택한 카드를 바꿈
					temp = d.cardArr[changeNum-1];
					d.cardArr[changeNum-1] = d.cardArr[10];
					d.cardArr[10] = temp;
					System.out.println(d.cardArr[10]+ " 카드가 "+ d.cardArr[changeNum-1]+ "로 바뀌었습니다");
					changeCard = false;
				} else if (changeNum == 0) {
					changeCard = false;
				} else {
					System.out.println("올바른 숫자를 입력하여 주십시오");
				}
		}
		d.pickCardMe();
		d.resultPlayer();
		
		int ran = (int)(Math.random()*2);	//컴퓨터가 0 혹은 1의 숫자를 생성
		if (ran == 1) {						//1일 경우 랜덤한 카드를 바꿈
			int ranNum = (int)(Math.random()*5+5);
			temp = d.cardArr[ranNum];
			d.cardArr[ranNum] = d.cardArr[11];
			d.cardArr[11] = temp;
		}//if문 종료
		System.out.println("-------------");
		System.out.print("player의 점수는 ");
		int scoreMe = d.resultPlayer();
		System.out.println(d.resultPlayer());
		d.pickCardComAll();
		System.out.print("com의 점수는 ");
		int scoreCom = d.resultCom();
		System.out.println(d.resultCom());
		for(int i=3; i<=13; i++) {
			if (scoreMe == 13 && scoreCom == 13) {
				if (d.cardArr[4].number > d.cardArr[9].number) {
					System.out.println("이겼습니다!");
				} else if(d.cardArr[4].number == d.cardArr[9].number) {
					if (d.cardArr[4].kind > d.cardArr[9].kind) {
						System.out.println("이겼습니다!");
					} else System.out.println("졌습니다!");
				} else System.out.println("졌습니다!");
				break;
			}
			if (scoreMe==scoreCom && scoreMe==i) {
				if (i != 4 && i != 5 && i != 10 && i != 11 && i != 12) {
					if (d.cardArr[4].number > d.cardArr[9].number) {
						System.out.println("이겼습니다!");
					} else if(d.cardArr[4].number == d.cardArr[9].number) {
						if (d.cardArr[4].kind > d.cardArr[9].kind) {
							System.out.println("이겼습니다!");
						} else System.out.println("졌습니다!");
					} else System.out.println("졌습니다!");
				}
				if (i == 4) {	//포카드
					if (d.cardArr[2].number > d.cardArr[7].number) {
						System.out.println("이겼습니다!");
					} else System.out.println("졌습니다!");
				}
				if (i == 5 || i == 10) {	//풀하우스
					if (d.cardArr[2].number > d.cardArr[7].number) {
						System.out.println("이겼습니다!");
					} else if(d.cardArr[2].number == d.cardArr[7].number) {
						if (d.cardArr[2].kind > d.cardArr[7].kind) {
							System.out.println("이겼습니다!");
						} else System.out.println("졌습니다!");
					} else System.out.println("졌습니다!");
				}
				if (i == 11) {	//투페어
					if (d.cardArr[3].number > d.cardArr[8].number) {
						System.out.println("이겼습니다!");
					} else if (d.cardArr[3].number == d.cardArr[8].number) {
						if (d.cardArr[3].kind > d.cardArr[8].kind) {
							System.out.println("이겼습니다!");
						} else System.out.println("졌습니다!");
					} else System.out.println("졌습니다!");
				}
				if (i == 12) {	//원페어
					if (d.cardArr[0].number == d.cardArr[1].number && d.cardArr[5].number == d.cardArr[6].number) {
						if (d.cardArr[1].number > d.cardArr[6].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[1].number == d.cardArr[6].number) {
							if (d.cardArr[1].kind > d.cardArr[6].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[1].number == d.cardArr[2].number && d.cardArr[5].number == d.cardArr[6].number) {
						if (d.cardArr[1].number > d.cardArr[6].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[1].number == d.cardArr[6].number) {
							if (d.cardArr[1].kind > d.cardArr[6].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[2].number == d.cardArr[3].number && d.cardArr[5].number == d.cardArr[6].number) {
						if (d.cardArr[3].number > d.cardArr[6].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[3].number == d.cardArr[6].number) {
							if (d.cardArr[3].kind > d.cardArr[6].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[3].number == d.cardArr[4].number && d.cardArr[5].number == d.cardArr[6].number) {
						if (d.cardArr[3].number > d.cardArr[6].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[3].number == d.cardArr[6].number) {
							if (d.cardArr[3].kind > d.cardArr[6].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[0].number == d.cardArr[1].number && d.cardArr[6].number == d.cardArr[7].number) {
						if (d.cardArr[1].number > d.cardArr[6].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[1].number == d.cardArr[6].number) {
							if (d.cardArr[1].kind > d.cardArr[6].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[1].number == d.cardArr[2].number && d.cardArr[6].number == d.cardArr[7].number) {
						if (d.cardArr[1].number > d.cardArr[6].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[1].number == d.cardArr[6].number) {
							if (d.cardArr[1].kind > d.cardArr[6].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[2].number == d.cardArr[3].number && d.cardArr[6].number == d.cardArr[7].number) {
						if (d.cardArr[3].number > d.cardArr[6].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[3].number == d.cardArr[6].number) {
							if (d.cardArr[3].kind > d.cardArr[6].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[3].number == d.cardArr[4].number && d.cardArr[6].number == d.cardArr[7].number) {
						if (d.cardArr[3].number > d.cardArr[6].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[3].number == d.cardArr[6].number) {
							if (d.cardArr[3].kind > d.cardArr[6].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[0].number == d.cardArr[1].number && d.cardArr[7].number == d.cardArr[8].number) {
						if (d.cardArr[1].number > d.cardArr[8].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[1].number == d.cardArr[8].number) {
							if (d.cardArr[1].kind > d.cardArr[8].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[1].number == d.cardArr[2].number && d.cardArr[7].number == d.cardArr[8].number) {
						if (d.cardArr[1].number > d.cardArr[8].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[1].number == d.cardArr[8].number) {
							if (d.cardArr[1].kind > d.cardArr[8].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[2].number == d.cardArr[3].number && d.cardArr[7].number == d.cardArr[8].number) {
						if (d.cardArr[3].number > d.cardArr[8].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[3].number == d.cardArr[8].number) {
							if (d.cardArr[3].kind > d.cardArr[8].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[3].number == d.cardArr[4].number && d.cardArr[7].number == d.cardArr[8].number) {
						if (d.cardArr[3].number > d.cardArr[8].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[3].number == d.cardArr[8].number) {
							if (d.cardArr[3].kind > d.cardArr[8].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[0].number == d.cardArr[1].number && d.cardArr[8].number == d.cardArr[9].number) {
						if (d.cardArr[1].number > d.cardArr[8].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[1].number == d.cardArr[8].number) {
							if (d.cardArr[1].kind > d.cardArr[8].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[1].number == d.cardArr[2].number && d.cardArr[8].number == d.cardArr[9].number) {
						if (d.cardArr[1].number > d.cardArr[8].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[1].number == d.cardArr[8].number) {
							if (d.cardArr[1].kind > d.cardArr[8].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[2].number == d.cardArr[3].number && d.cardArr[8].number == d.cardArr[9].number) {
						if (d.cardArr[3].number > d.cardArr[8].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[3].number == d.cardArr[8].number) {
							if (d.cardArr[3].kind > d.cardArr[8].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
					if (d.cardArr[3].number == d.cardArr[4].number && d.cardArr[8].number == d.cardArr[9].number) {
						if (d.cardArr[3].number > d.cardArr[8].number) {
							System.out.println("이겼습니다!");
						} else if (d.cardArr[3].number == d.cardArr[8].number) {
							if (d.cardArr[3].kind > d.cardArr[8].kind) {
								System.out.println("이겼습니다!");
							} else System.out.println("졌습니다!");
						}else System.out.println("졌습니다!");
					}
				}
			}
			if (scoreMe<scoreCom) {
				System.out.println("이겼습니다!");
				break;
			} else {
				System.out.println("졌습니다!");
				break;
			}
		}
		
	}
}

class Card {
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	int kind;
	int number;
	
	Card() {
		this(SPADE, 1);
	}
	
	Card(int kind, int number){
		this.kind = kind;
		this.number = number;
	}
	
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String[] numbers = {"", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
		return "kind : "+ kinds[this.kind]+ ", number : "+ numbers[this.number];
	}//Card클래스 끝
	
	
}

class Deck {
	final int CARD_NUM = 52;
	Card cardArr[] = new Card[CARD_NUM];
	
	Deck () {
		int i=0;
		
		for(int k=Card.KIND_MAX; k>0; k--)
			for(int n=0; n<Card.NUM_MAX; n++) {
				cardArr[i++] = new Card(k, n+1);
			}
	}
	
	Card pick(int index) {
		return cardArr[index];
	}
	
	Card pick() {
		int index = (int)(Math.random()*CARD_NUM);
		return pick(index);
	}
	
	void shuffle() {
		for(int i=0; i<cardArr.length; i++) {
			int r = (int)(Math.random()*cardArr.length);
			
			Card tmp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = tmp;
		}
	}
		Card temp;
	void pickCardMe() {
		for (int j=0; j<4; j++) {
			for (int i=j+1; i<5; i++) {
				if (cardArr[j].number>cardArr[i].number) {
					temp = cardArr[j];
					cardArr[j] = cardArr[i];
					cardArr[i] = temp;
				}
			}
		}
		for (int i=0; i<5; i++)
		System.out.println(cardArr[i]);
	}	//Deck클래스 끝
	void pickCardCom() {
		for (int i = 7; i<10; i++)
			System.out.println(cardArr[i]);
	}
	void pickCardComAll() {
		for (int j=5; j<9; j++) {
			for (int i=j+1; i<10; i++) {
				if (cardArr[j].number>cardArr[i].number) {
					temp = cardArr[j];
					cardArr[j] = cardArr[i];
					cardArr[i] = temp;
				}
			}
		}
		for (int i = 5; i<10; i++)
			System.out.println(cardArr[i]);
	}
	
	public int resultPlayer() {
		int player;
		if (cardArr[0].kind==cardArr[1].kind && cardArr[1].kind==cardArr[2].kind && 
				cardArr[2].kind==cardArr[3].kind && cardArr[3].kind==cardArr[4].kind && cardArr[4].kind==4 &&
				cardArr[0].number==1 && cardArr[1].number==10 && cardArr[2].number==11	&& cardArr[3].number==12 &&
				cardArr[4].number==13) {
			player = 1;
			System.out.println("로얄 스트레이트 플러쉬 입니다.");
		} else if (cardArr[0].kind==cardArr[1].kind && cardArr[1].kind==cardArr[2].kind && 
				cardArr[2].kind==cardArr[3].kind && cardArr[3].kind==cardArr[4].kind && cardArr[0].kind==4 &&
				cardArr[0].number==1 && cardArr[1].number==2 && cardArr[2].number==3 && cardArr[3].number==4 && cardArr[4].number==5) {
			player = 2;
			System.out.println("백 스트레이트 플러쉬 입니다.");
		} else if (((cardArr[0].number+1==cardArr[1].number && cardArr[1].number+1==cardArr[2].number && cardArr[2].number+1
				==cardArr[3].number && cardArr[3].number+1==cardArr[4].number) || 
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==3 && cardArr[3].number==4 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==3 && cardArr[3].number==12 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==11 && cardArr[3].number==12 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==10 && cardArr[2].number==11 && cardArr[3].number==12 && cardArr[4].number==13)) &&
				cardArr[0].kind==cardArr[1].kind && cardArr[0].kind==cardArr[2].kind && cardArr[0].kind==cardArr[3].kind && cardArr[0].kind==cardArr[4].kind) {
			player = 3;
			System.out.println("스트레이트 플러쉬 입니다.");
		} else if ((cardArr[0].number==cardArr[1].number && cardArr[1].number==cardArr[2].number && cardArr[2].number==cardArr[3].number) || 
				(cardArr[1].number==cardArr[2].number && cardArr[2].number==cardArr[3].number && cardArr[3].number==cardArr[4].number)) {
			player = 4;
			System.out.println("포카드 입니다.");
		} else if (((cardArr[0].number==cardArr[1].number && cardArr[1].number==cardArr[2].number) && (cardArr[3].number==cardArr[4].number)) ||
				((cardArr[0].number==cardArr[1].number) && (cardArr[2].number==cardArr[3].number && cardArr[3].number==cardArr[4].number))) {
			player = 5;
			System.out.println("풀하우스 입니다.");
		} else if (cardArr[0].kind==cardArr[1].kind && cardArr[1].kind==cardArr[2].kind && cardArr[2].kind==cardArr[3].kind && cardArr[3].kind==cardArr[4].kind) {
			player = 6;
			System.out.println("플러쉬 입니다.");
		} else if (cardArr[0].number==1 && cardArr[1].number==10 && cardArr[2].number==11	&& cardArr[3].number==12 &&
				cardArr[4].number==13) {
			player = 7;
			System.out.println("마운틴 입니다.");
		} else if (cardArr[0].number==1 && cardArr[1].number==2 && cardArr[2].number==3 && cardArr[3].number==4 && cardArr[4].number==5) {
			player = 8;
			System.out.println("백스트레이트 입니다.");
		} else if ((cardArr[0].number+1==cardArr[1].number && cardArr[1].number+1==cardArr[2].number && cardArr[2].number+1
				==cardArr[3].number && cardArr[3].number+1==cardArr[4].number) || 
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==3 && cardArr[3].number==4 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==3 && cardArr[3].number==12 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==11 && cardArr[3].number==12 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==10 && cardArr[2].number==11 && cardArr[3].number==12 && cardArr[4].number==13)) {
			player = 9;
			System.out.println(cardArr[4].number+ "스트레이트 입니다.");
		} else if ((cardArr[0].number==cardArr[1].number && cardArr[1].number==cardArr[2].number) || (cardArr[2].number==cardArr[3].number && cardArr[3].number==cardArr[4].number) || (cardArr[1].number==cardArr[2].number && cardArr[2].number==cardArr[3].number)) {
			player = 10;
			System.out.println("트리플 입니다.");
		} else if ((cardArr[0].number==cardArr[1].number && cardArr[2].number==cardArr[3].number) || (cardArr[0].number==cardArr[1].number && cardArr[3].number==cardArr[4].number) || 
			(cardArr[1].number==cardArr[2].number && cardArr[3].number==cardArr[4].number)){
			player = 11;
			System.out.println("투페어 입니다.");
		} else if ((cardArr[0].number==cardArr[1].number) || (cardArr[1].number==cardArr[2].number) || (cardArr[2].number==cardArr[3].number) || (cardArr[3].number==cardArr[4].number)) {
			player = 12;
			System.out.println("원페어 입니다.");
		} else {
			player = 13;
			System.out.println(cardArr[4].number+ "하이 입니다.");
		}
		return player;
	}
	public int resultCom() {
		int com;
		if (cardArr[5].kind==cardArr[6].kind && cardArr[6].kind==cardArr[7].kind && 
				cardArr[7].kind==cardArr[8].kind && cardArr[8].kind==cardArr[9].kind && cardArr[9].kind==4 &&
				cardArr[5].number==1 && cardArr[6].number==10 && cardArr[7].number==11	&& cardArr[8].number==12 &&
				cardArr[9].number==13) {
			com = 1;
			System.out.println("로얄 스트레이트 플러쉬 입니다.");
		} else if (cardArr[5].kind==cardArr[6].kind && cardArr[6].kind==cardArr[7].kind && 
				cardArr[7].kind==cardArr[8].kind && cardArr[8].kind==cardArr[9].kind && cardArr[5].kind==4 &&
				cardArr[5].number==6 && cardArr[6].number==2 && cardArr[7].number==3 && cardArr[8].number==4 && cardArr[9].number==5) {
			com = 2;
			System.out.println("백 스트레이트 플러쉬 입니다.");
		} else if (((cardArr[5].number+1==cardArr[6].number && cardArr[6].number+1==cardArr[7].number && cardArr[7].number+1
				==cardArr[8].number && cardArr[8].number+1==cardArr[9].number) || 
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==3 && cardArr[8].number==4 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==3 && cardArr[8].number==12 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==11 && cardArr[8].number==12 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==10 && cardArr[7].number==11 && cardArr[8].number==12 && cardArr[9].number==13)) &&
				cardArr[5].kind==cardArr[6].kind && cardArr[5].kind==cardArr[7].kind && cardArr[5].kind==cardArr[8].kind && cardArr[5].kind==cardArr[9].kind) {
			com = 3;
			System.out.println("스트레이트 플러쉬 입니다.");
		} else if ((cardArr[5].number==cardArr[6].number && cardArr[6].number==cardArr[7].number && cardArr[7].number==cardArr[8].number) || 
				(cardArr[6].number==cardArr[7].number && cardArr[7].number==cardArr[8].number && cardArr[8].number==cardArr[9].number)) {
			com = 4;
			System.out.println("포카드 입니다.");
		} else if (((cardArr[5].number==cardArr[6].number && cardArr[6].number==cardArr[7].number) && (cardArr[8].number==cardArr[9].number)) ||
				((cardArr[5].number==cardArr[6].number) && (cardArr[7].number==cardArr[8].number && cardArr[8].number==cardArr[9].number))) {
			com = 5;
			System.out.println("풀하우스 입니다.");
		} else if (cardArr[5].kind==cardArr[6].kind && cardArr[6].kind==cardArr[7].kind && cardArr[7].kind==cardArr[8].kind && cardArr[8].kind==cardArr[9].kind) {
			com = 6;
			System.out.println("플러쉬 입니다.");
		} else if (cardArr[5].number==1 && cardArr[6].number==10 && cardArr[7].number==11	&& cardArr[8].number==12 &&
				cardArr[9].number==13) {
			com = 7;
			System.out.println("마운틴 입니다.");
		} else if (cardArr[5].number==1 && cardArr[6].number==2 && cardArr[7].number==3 && cardArr[8].number==4 && cardArr[9].number==5) {
			com = 8;
			System.out.println("백스트레이트 입니다.");
		} else if ((cardArr[5].number+1==cardArr[6].number && cardArr[6].number+1==cardArr[7].number && cardArr[7].number+1
				==cardArr[8].number && cardArr[8].number+1==cardArr[9].number) || 
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==3 && cardArr[8].number==4 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==3 && cardArr[8].number==12 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==11 && cardArr[8].number==12 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==10 && cardArr[7].number==11 && cardArr[8].number==12 && cardArr[9].number==13)) {
			com = 9;
			System.out.println(cardArr[9].number+ "스트레이트 입니다.");
		} else if ((cardArr[5].number==cardArr[6].number && cardArr[6].number==cardArr[7].number) || (cardArr[7].number==cardArr[8].number && cardArr[8].number==cardArr[9].number) || (cardArr[6].number==cardArr[7].number && cardArr[7].number==cardArr[8].number)) {
			com = 10;
			System.out.println("트리플 입니다.");
		} else if ((cardArr[5].number==cardArr[6].number && cardArr[7].number==cardArr[8].number) || (cardArr[5].number==cardArr[6].number && cardArr[8].number==cardArr[9].number) || 
			(cardArr[6].number==cardArr[7].number && cardArr[8].number==cardArr[9].number)){
			com = 11;
			System.out.println("투페어 입니다.");
		} else if ((cardArr[5].number==cardArr[6].number) || (cardArr[6].number==cardArr[7].number) || (cardArr[7].number==cardArr[8].number) || (cardArr[8].number==cardArr[9].number)) {
			com = 12;
			System.out.println("원페어 입니다.");
		} else {
			com = 13;
			System.out.println(cardArr[9].number+ "하이 입니다.");
		}
		return com;
	}
}
	
	
	

