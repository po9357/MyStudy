package com.mystudy.card;

import java.util.Scanner;

public class My_Ex01_Card {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Card temp;
		int player = 0;
		int com = 0;
		System.out.println("ī�带 ���� �ֽ��ϴ�.");
		Deck d = new Deck();
		Card c = new Card();
		d.shuffle();
		
		System.out.println("�÷��̾�1���� ī�带 5�� �������ݴϴ�.");
		d.pickCardMe();
		
		System.out.println("com���� ī�带 5�� �������ݴϴ�.");
		
		System.out.println(">>> com�� ������ ī�� 3��");
		d.pickCardCom();
		
		boolean changeCard = true;
		while (changeCard) {
			System.out.println("�ٲٰ� ���� ī�带 �Է��Ͽ� �ֽʽÿ�. (������� 1 ~ 5, �ٲٰ� ���� ī�尡 ���ٸ� 0)");
			int changeNum = sc.nextInt();
				if(changeNum>=1 && changeNum<=5) {		//���� ��ο� �� ī��� ������ ī�带 �ٲ�
					temp = d.cardArr[changeNum-1];
					d.cardArr[changeNum-1] = d.cardArr[10];
					d.cardArr[10] = temp;
					System.out.println(d.cardArr[10]+ " ī�尡 "+ d.cardArr[changeNum-1]+ "�� �ٲ�����ϴ�");
					changeCard = false;
				} else if (changeNum == 0) {
					changeCard = false;
				} else {
					System.out.println("�ùٸ� ���ڸ� �Է��Ͽ� �ֽʽÿ�");
				}
		}
		d.pickCardMe();
		d.resultPlayer();
		
		int ran = (int)(Math.random()*2);	//��ǻ�Ͱ� 0 Ȥ�� 1�� ���ڸ� ����
		if (ran == 1) {						//1�� ��� ������ ī�带 �ٲ�
			int ranNum = (int)(Math.random()*5+5);
			temp = d.cardArr[ranNum];
			d.cardArr[ranNum] = d.cardArr[11];
			d.cardArr[11] = temp;
		}//if�� ����
		System.out.println("-------------");
		System.out.print("player�� ������ ");
		int scoreMe = d.resultPlayer();
		System.out.println(d.resultPlayer());
		d.pickCardComAll();
		System.out.print("com�� ������ ");
		int scoreCom = d.resultCom();
		System.out.println(d.resultCom());
		for(int i=3; i<=13; i++) {
			if (scoreMe == 13 && scoreCom == 13) {
				if (d.cardArr[4].number > d.cardArr[9].number) {
					System.out.println("�̰���ϴ�!");
				} else if(d.cardArr[4].number == d.cardArr[9].number) {
					if (d.cardArr[4].kind > d.cardArr[9].kind) {
						System.out.println("�̰���ϴ�!");
					} else System.out.println("�����ϴ�!");
				} else System.out.println("�����ϴ�!");
				break;
			}
			if (scoreMe==scoreCom && scoreMe==i) {
				if (i != 4 && i != 5 && i != 10 && i != 11 && i != 12) {
					if (d.cardArr[4].number > d.cardArr[9].number) {
						System.out.println("�̰���ϴ�!");
					} else if(d.cardArr[4].number == d.cardArr[9].number) {
						if (d.cardArr[4].kind > d.cardArr[9].kind) {
							System.out.println("�̰���ϴ�!");
						} else System.out.println("�����ϴ�!");
					} else System.out.println("�����ϴ�!");
				}
				if (i == 4) {	//��ī��
					if (d.cardArr[2].number > d.cardArr[7].number) {
						System.out.println("�̰���ϴ�!");
					} else System.out.println("�����ϴ�!");
				}
				if (i == 5 || i == 10) {	//Ǯ�Ͽ콺
					if (d.cardArr[2].number > d.cardArr[7].number) {
						System.out.println("�̰���ϴ�!");
					} else if(d.cardArr[2].number == d.cardArr[7].number) {
						if (d.cardArr[2].kind > d.cardArr[7].kind) {
							System.out.println("�̰���ϴ�!");
						} else System.out.println("�����ϴ�!");
					} else System.out.println("�����ϴ�!");
				}
				if (i == 11) {	//�����
					if (d.cardArr[3].number > d.cardArr[8].number) {
						System.out.println("�̰���ϴ�!");
					} else if (d.cardArr[3].number == d.cardArr[8].number) {
						if (d.cardArr[3].kind > d.cardArr[8].kind) {
							System.out.println("�̰���ϴ�!");
						} else System.out.println("�����ϴ�!");
					} else System.out.println("�����ϴ�!");
				}
				if (i == 12) {	//�����
					if (d.cardArr[0].number == d.cardArr[1].number && d.cardArr[5].number == d.cardArr[6].number) {
						if (d.cardArr[1].number > d.cardArr[6].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[1].number == d.cardArr[6].number) {
							if (d.cardArr[1].kind > d.cardArr[6].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[1].number == d.cardArr[2].number && d.cardArr[5].number == d.cardArr[6].number) {
						if (d.cardArr[1].number > d.cardArr[6].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[1].number == d.cardArr[6].number) {
							if (d.cardArr[1].kind > d.cardArr[6].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[2].number == d.cardArr[3].number && d.cardArr[5].number == d.cardArr[6].number) {
						if (d.cardArr[3].number > d.cardArr[6].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[3].number == d.cardArr[6].number) {
							if (d.cardArr[3].kind > d.cardArr[6].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[3].number == d.cardArr[4].number && d.cardArr[5].number == d.cardArr[6].number) {
						if (d.cardArr[3].number > d.cardArr[6].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[3].number == d.cardArr[6].number) {
							if (d.cardArr[3].kind > d.cardArr[6].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[0].number == d.cardArr[1].number && d.cardArr[6].number == d.cardArr[7].number) {
						if (d.cardArr[1].number > d.cardArr[6].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[1].number == d.cardArr[6].number) {
							if (d.cardArr[1].kind > d.cardArr[6].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[1].number == d.cardArr[2].number && d.cardArr[6].number == d.cardArr[7].number) {
						if (d.cardArr[1].number > d.cardArr[6].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[1].number == d.cardArr[6].number) {
							if (d.cardArr[1].kind > d.cardArr[6].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[2].number == d.cardArr[3].number && d.cardArr[6].number == d.cardArr[7].number) {
						if (d.cardArr[3].number > d.cardArr[6].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[3].number == d.cardArr[6].number) {
							if (d.cardArr[3].kind > d.cardArr[6].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[3].number == d.cardArr[4].number && d.cardArr[6].number == d.cardArr[7].number) {
						if (d.cardArr[3].number > d.cardArr[6].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[3].number == d.cardArr[6].number) {
							if (d.cardArr[3].kind > d.cardArr[6].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[0].number == d.cardArr[1].number && d.cardArr[7].number == d.cardArr[8].number) {
						if (d.cardArr[1].number > d.cardArr[8].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[1].number == d.cardArr[8].number) {
							if (d.cardArr[1].kind > d.cardArr[8].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[1].number == d.cardArr[2].number && d.cardArr[7].number == d.cardArr[8].number) {
						if (d.cardArr[1].number > d.cardArr[8].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[1].number == d.cardArr[8].number) {
							if (d.cardArr[1].kind > d.cardArr[8].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[2].number == d.cardArr[3].number && d.cardArr[7].number == d.cardArr[8].number) {
						if (d.cardArr[3].number > d.cardArr[8].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[3].number == d.cardArr[8].number) {
							if (d.cardArr[3].kind > d.cardArr[8].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[3].number == d.cardArr[4].number && d.cardArr[7].number == d.cardArr[8].number) {
						if (d.cardArr[3].number > d.cardArr[8].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[3].number == d.cardArr[8].number) {
							if (d.cardArr[3].kind > d.cardArr[8].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[0].number == d.cardArr[1].number && d.cardArr[8].number == d.cardArr[9].number) {
						if (d.cardArr[1].number > d.cardArr[8].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[1].number == d.cardArr[8].number) {
							if (d.cardArr[1].kind > d.cardArr[8].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[1].number == d.cardArr[2].number && d.cardArr[8].number == d.cardArr[9].number) {
						if (d.cardArr[1].number > d.cardArr[8].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[1].number == d.cardArr[8].number) {
							if (d.cardArr[1].kind > d.cardArr[8].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[2].number == d.cardArr[3].number && d.cardArr[8].number == d.cardArr[9].number) {
						if (d.cardArr[3].number > d.cardArr[8].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[3].number == d.cardArr[8].number) {
							if (d.cardArr[3].kind > d.cardArr[8].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
					if (d.cardArr[3].number == d.cardArr[4].number && d.cardArr[8].number == d.cardArr[9].number) {
						if (d.cardArr[3].number > d.cardArr[8].number) {
							System.out.println("�̰���ϴ�!");
						} else if (d.cardArr[3].number == d.cardArr[8].number) {
							if (d.cardArr[3].kind > d.cardArr[8].kind) {
								System.out.println("�̰���ϴ�!");
							} else System.out.println("�����ϴ�!");
						}else System.out.println("�����ϴ�!");
					}
				}
			}
			if (scoreMe<scoreCom) {
				System.out.println("�̰���ϴ�!");
				break;
			} else {
				System.out.println("�����ϴ�!");
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
	}//CardŬ���� ��
	
	
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
	}	//DeckŬ���� ��
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
			System.out.println("�ξ� ��Ʈ����Ʈ �÷��� �Դϴ�.");
		} else if (cardArr[0].kind==cardArr[1].kind && cardArr[1].kind==cardArr[2].kind && 
				cardArr[2].kind==cardArr[3].kind && cardArr[3].kind==cardArr[4].kind && cardArr[0].kind==4 &&
				cardArr[0].number==1 && cardArr[1].number==2 && cardArr[2].number==3 && cardArr[3].number==4 && cardArr[4].number==5) {
			player = 2;
			System.out.println("�� ��Ʈ����Ʈ �÷��� �Դϴ�.");
		} else if (((cardArr[0].number+1==cardArr[1].number && cardArr[1].number+1==cardArr[2].number && cardArr[2].number+1
				==cardArr[3].number && cardArr[3].number+1==cardArr[4].number) || 
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==3 && cardArr[3].number==4 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==3 && cardArr[3].number==12 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==11 && cardArr[3].number==12 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==10 && cardArr[2].number==11 && cardArr[3].number==12 && cardArr[4].number==13)) &&
				cardArr[0].kind==cardArr[1].kind && cardArr[0].kind==cardArr[2].kind && cardArr[0].kind==cardArr[3].kind && cardArr[0].kind==cardArr[4].kind) {
			player = 3;
			System.out.println("��Ʈ����Ʈ �÷��� �Դϴ�.");
		} else if ((cardArr[0].number==cardArr[1].number && cardArr[1].number==cardArr[2].number && cardArr[2].number==cardArr[3].number) || 
				(cardArr[1].number==cardArr[2].number && cardArr[2].number==cardArr[3].number && cardArr[3].number==cardArr[4].number)) {
			player = 4;
			System.out.println("��ī�� �Դϴ�.");
		} else if (((cardArr[0].number==cardArr[1].number && cardArr[1].number==cardArr[2].number) && (cardArr[3].number==cardArr[4].number)) ||
				((cardArr[0].number==cardArr[1].number) && (cardArr[2].number==cardArr[3].number && cardArr[3].number==cardArr[4].number))) {
			player = 5;
			System.out.println("Ǯ�Ͽ콺 �Դϴ�.");
		} else if (cardArr[0].kind==cardArr[1].kind && cardArr[1].kind==cardArr[2].kind && cardArr[2].kind==cardArr[3].kind && cardArr[3].kind==cardArr[4].kind) {
			player = 6;
			System.out.println("�÷��� �Դϴ�.");
		} else if (cardArr[0].number==1 && cardArr[1].number==10 && cardArr[2].number==11	&& cardArr[3].number==12 &&
				cardArr[4].number==13) {
			player = 7;
			System.out.println("����ƾ �Դϴ�.");
		} else if (cardArr[0].number==1 && cardArr[1].number==2 && cardArr[2].number==3 && cardArr[3].number==4 && cardArr[4].number==5) {
			player = 8;
			System.out.println("�齺Ʈ����Ʈ �Դϴ�.");
		} else if ((cardArr[0].number+1==cardArr[1].number && cardArr[1].number+1==cardArr[2].number && cardArr[2].number+1
				==cardArr[3].number && cardArr[3].number+1==cardArr[4].number) || 
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==3 && cardArr[3].number==4 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==3 && cardArr[3].number==12 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==2 && cardArr[2].number==11 && cardArr[3].number==12 && cardArr[4].number==13) ||
				(cardArr[0].number==1 && cardArr[1].number+1==10 && cardArr[2].number==11 && cardArr[3].number==12 && cardArr[4].number==13)) {
			player = 9;
			System.out.println(cardArr[4].number+ "��Ʈ����Ʈ �Դϴ�.");
		} else if ((cardArr[0].number==cardArr[1].number && cardArr[1].number==cardArr[2].number) || (cardArr[2].number==cardArr[3].number && cardArr[3].number==cardArr[4].number) || (cardArr[1].number==cardArr[2].number && cardArr[2].number==cardArr[3].number)) {
			player = 10;
			System.out.println("Ʈ���� �Դϴ�.");
		} else if ((cardArr[0].number==cardArr[1].number && cardArr[2].number==cardArr[3].number) || (cardArr[0].number==cardArr[1].number && cardArr[3].number==cardArr[4].number) || 
			(cardArr[1].number==cardArr[2].number && cardArr[3].number==cardArr[4].number)){
			player = 11;
			System.out.println("����� �Դϴ�.");
		} else if ((cardArr[0].number==cardArr[1].number) || (cardArr[1].number==cardArr[2].number) || (cardArr[2].number==cardArr[3].number) || (cardArr[3].number==cardArr[4].number)) {
			player = 12;
			System.out.println("����� �Դϴ�.");
		} else {
			player = 13;
			System.out.println(cardArr[4].number+ "���� �Դϴ�.");
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
			System.out.println("�ξ� ��Ʈ����Ʈ �÷��� �Դϴ�.");
		} else if (cardArr[5].kind==cardArr[6].kind && cardArr[6].kind==cardArr[7].kind && 
				cardArr[7].kind==cardArr[8].kind && cardArr[8].kind==cardArr[9].kind && cardArr[5].kind==4 &&
				cardArr[5].number==6 && cardArr[6].number==2 && cardArr[7].number==3 && cardArr[8].number==4 && cardArr[9].number==5) {
			com = 2;
			System.out.println("�� ��Ʈ����Ʈ �÷��� �Դϴ�.");
		} else if (((cardArr[5].number+1==cardArr[6].number && cardArr[6].number+1==cardArr[7].number && cardArr[7].number+1
				==cardArr[8].number && cardArr[8].number+1==cardArr[9].number) || 
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==3 && cardArr[8].number==4 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==3 && cardArr[8].number==12 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==11 && cardArr[8].number==12 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==10 && cardArr[7].number==11 && cardArr[8].number==12 && cardArr[9].number==13)) &&
				cardArr[5].kind==cardArr[6].kind && cardArr[5].kind==cardArr[7].kind && cardArr[5].kind==cardArr[8].kind && cardArr[5].kind==cardArr[9].kind) {
			com = 3;
			System.out.println("��Ʈ����Ʈ �÷��� �Դϴ�.");
		} else if ((cardArr[5].number==cardArr[6].number && cardArr[6].number==cardArr[7].number && cardArr[7].number==cardArr[8].number) || 
				(cardArr[6].number==cardArr[7].number && cardArr[7].number==cardArr[8].number && cardArr[8].number==cardArr[9].number)) {
			com = 4;
			System.out.println("��ī�� �Դϴ�.");
		} else if (((cardArr[5].number==cardArr[6].number && cardArr[6].number==cardArr[7].number) && (cardArr[8].number==cardArr[9].number)) ||
				((cardArr[5].number==cardArr[6].number) && (cardArr[7].number==cardArr[8].number && cardArr[8].number==cardArr[9].number))) {
			com = 5;
			System.out.println("Ǯ�Ͽ콺 �Դϴ�.");
		} else if (cardArr[5].kind==cardArr[6].kind && cardArr[6].kind==cardArr[7].kind && cardArr[7].kind==cardArr[8].kind && cardArr[8].kind==cardArr[9].kind) {
			com = 6;
			System.out.println("�÷��� �Դϴ�.");
		} else if (cardArr[5].number==1 && cardArr[6].number==10 && cardArr[7].number==11	&& cardArr[8].number==12 &&
				cardArr[9].number==13) {
			com = 7;
			System.out.println("����ƾ �Դϴ�.");
		} else if (cardArr[5].number==1 && cardArr[6].number==2 && cardArr[7].number==3 && cardArr[8].number==4 && cardArr[9].number==5) {
			com = 8;
			System.out.println("�齺Ʈ����Ʈ �Դϴ�.");
		} else if ((cardArr[5].number+1==cardArr[6].number && cardArr[6].number+1==cardArr[7].number && cardArr[7].number+1
				==cardArr[8].number && cardArr[8].number+1==cardArr[9].number) || 
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==3 && cardArr[8].number==4 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==3 && cardArr[8].number==12 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==2 && cardArr[7].number==11 && cardArr[8].number==12 && cardArr[9].number==13) ||
				(cardArr[5].number==1 && cardArr[6].number+1==10 && cardArr[7].number==11 && cardArr[8].number==12 && cardArr[9].number==13)) {
			com = 9;
			System.out.println(cardArr[9].number+ "��Ʈ����Ʈ �Դϴ�.");
		} else if ((cardArr[5].number==cardArr[6].number && cardArr[6].number==cardArr[7].number) || (cardArr[7].number==cardArr[8].number && cardArr[8].number==cardArr[9].number) || (cardArr[6].number==cardArr[7].number && cardArr[7].number==cardArr[8].number)) {
			com = 10;
			System.out.println("Ʈ���� �Դϴ�.");
		} else if ((cardArr[5].number==cardArr[6].number && cardArr[7].number==cardArr[8].number) || (cardArr[5].number==cardArr[6].number && cardArr[8].number==cardArr[9].number) || 
			(cardArr[6].number==cardArr[7].number && cardArr[8].number==cardArr[9].number)){
			com = 11;
			System.out.println("����� �Դϴ�.");
		} else if ((cardArr[5].number==cardArr[6].number) || (cardArr[6].number==cardArr[7].number) || (cardArr[7].number==cardArr[8].number) || (cardArr[8].number==cardArr[9].number)) {
			com = 12;
			System.out.println("����� �Դϴ�.");
		} else {
			com = 13;
			System.out.println(cardArr[9].number+ "���� �Դϴ�.");
		}
		return com;
	}
}
	
	
	

