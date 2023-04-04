package map;

import java.util.ArrayList;
import java.util.Random;

import CreaturesInfo.CombatStageInfo;
import Events.Campsite;
import Events.Merchant;
import StageSystem.CombatStage;
import StageSystem.EventStage;
import StageSystem.Stage;

public class MapMaker {

	public ArrayList<ArrayList<Node>> NodeList = new ArrayList<ArrayList<Node>>();
	// 2���� ArrayList ����
	private ArrayList<Node> tempAL = null;

	final int firstFloorValue = 3;
	// 1���� 3���� ���� ����
	final int FloorMaxValue = 4;
	// 1���� ���� 1���� �����ϸ� �ִ� 4���� ���� �̷����
	public final int floor = 14;
	// ���� 14���� �̷����

	public static int currentStageNum = 1;
	//��ü �ʿ� ���� �� ��ȣ

	Random random = new Random();

	public MapMaker() {
		loadMap();
	}
	
	//node �̳�Ŭ����. Node Ŭ������ ��ǻ� ���� ������ ��
	public class Node {
		public ArrayList<Node> path;
		//�̾��� ���� ��� AL
		
		int mapnumber;
		
		public String maptype;
		
		public String nodeName;
		//��� �̸�. [��_�� ��ȣ]�� �̷����
		
		int stagenumber;

		int roomNum;
		// �� ��ȣ, �ڽ��� �� ������ ���ʿ������� �� ��° �濡 �ִ����� ��Ÿ��
		
		public EventStage Estage = new EventStage();
		public CombatStage Cstage = new CombatStage();

		Node(int num, String type, int stnum, String nodeN, int roomNum) {
			mapnumber = num;
			maptype = type;
			stagenumber = stnum;
			nodeName = nodeN;
			this.roomNum = roomNum;
			path = new ArrayList<Node>();
			StageSet();
		}

		public void StageSet() {
			if (maptype.equals("Combat") || maptype.equals("Boss")) {
				CombatStage Stage = CombatStageInfo.GiveCombatStage(stagenumber);
				Cstage = Stage;
			}
			else if (maptype.equals("Camp"))
			{
				EventStage Event = new EventStage();
				Campsite camp = new Campsite();
				Event.event = camp;
				Estage = Event;
			}
			else if (maptype.equals("Merchant"))
			{
				EventStage Event = new EventStage();
				Merchant merc = new Merchant();
				Event.event = merc;
				Estage = Event;
			}
		}

		public void StageStart() {
			if (this.maptype.equals("Combat") || this.maptype.equals("Boss")) {
				Cstage.StageStart();
			} else  {
				Estage.Use();
			}
		}
	}
	

	public void loadMap() {
		for (int i = 1; i <= 14; i++) {
			makeFloor(i);
			//�� �����
		}
		connectNode();
		// �� �ձ�
	}
	
	
	private boolean makeFloor(int floor) {
		if (floor == 1) {
			if (makeFirstFloor()) {
				currentStageNum++;
			}
			return false;
		}

		if (floor == this.floor) {
			if (makeLastFloor()) {
				currentStageNum++;
				return true;
			}
			return false;
		}

		String roomString = "Combat";

		if (floor == this.floor - 1) {
			roomString = "Camp";
		}
		else if (floor == 7) {
			roomString = "Merchant";
		}

		tempAL = new ArrayList<Node>();
		for (int i = 0; i < random.nextInt(3) + 2; i++) {
			
			tempAL.add(new Node(currentStageNum, roomString, random.nextInt(8), makeRoomName(floor, i, roomString), i));
			//System.out.print("x");
		}
		//System.out.println();
		if (tempAL.size() < 5) {
			NodeList.add(tempAL);
			currentStageNum++;
			return true;
		}

		return false;
	}

	private boolean makeFirstFloor() {
		tempAL = new ArrayList<Node>();

		for (int i = 0; i < firstFloorValue; i++) {
			tempAL.add(new Node(currentStageNum, "Combat", random.nextInt(8), makeRoomName(1, i, "Combat"), i));
		}
		if (tempAL.size() == firstFloorValue) {
			NodeList.add(tempAL);
			return true;
		}
		return false;
	}

	private boolean makeLastFloor() {
		tempAL = new ArrayList<Node>();

		tempAL.add(new Node(currentStageNum, "Boss", 8, makeRoomName(this.floor, 0, "Boss"), 1));
		if (tempAL.size() == 1) {
			NodeList.add(tempAL);
			return true;
		}
		return false;
	}

	private String makeRoomName(int floor, int roomNum, String RS) {
		String roomName = "";
		roomName = roomName.concat(Integer.toString(floor));
		roomName = roomName.concat("��_");
		roomName = roomName.concat(Integer.toString(roomNum+1));
		roomName = roomName.concat("�� ��(");
		roomName = roomName.concat(RS + ")");
		return roomName;
	}


	// �� ���
	public void printMap() {
		for (int i = 0; i < this.floor; i++) {
			System.out.printf("%d %d", NodeList.get(i).size(), i);
			for (int j = 0; j < NodeList.get(i).size(); j++) {
				Node tempNode = NodeList.get(i).get(j);
				//System.out.print(NodeList.get(i).get(j).maptype);
				System.out.printf("%8s", tempNode.nodeName);
			}
			System.out.println();
		}
	}

	public boolean connectNode() {
		for (int i = 0; i < this.floor - 1; i++) {
			ArrayList<Node> preNodes = NodeList.get(i);
			ArrayList<Node> postNodes = NodeList.get(i + 1);

			int pre = preNodes.size();
			int post = postNodes.size();
			if (i==12)
			{
				for(Node node : preNodes) {
					node.path.add(postNodes.get(0));
					System.out.println("asdf");
				}
			}
			else
			{
			if (postNodes.get(0).maptype == "Boss") {
				for (Node node : preNodes) {
					node.path.add(postNodes.get(0));
				}
			}
			if (pre > post) {
				while (true) {
					boolean blockingPath = false;
					for (Node node : preNodes) {
						//System.out.printf("%d %d\n", node.roomNum, post);

						if (node.roomNum == 0) {
							node.path.add(postNodes.get(0));
						} else if (node.roomNum == pre - 1 && node.roomNum != post) {
							if (post > pre-1)
								node.path.add(postNodes.get(pre - 1));
							else
								node.path.add(postNodes.get(post-1));
						}

						else if (!blockingPath && random.nextBoolean()) {
							node.path.add(postNodes.get(node.roomNum - 1));
						}

						else if (node.roomNum == post) {
							node.path.add(postNodes.get(node.roomNum - 1));
							//System.out.println("sd");
						} else {
							node.path.add(postNodes.get(node.roomNum));
							if (node.roomNum <= post - 2 && random.nextBoolean()) {
								node.path.add(postNodes.get(node.roomNum + 1));
								blockingPath = true;
								continue;
							}
							blockingPath = false;
						}
					}
					break;
				}

			} else {
				int MaxNode = post - pre;
				for (Node node : preNodes) {
					//System.out.printf("%d %d\n", node.roomNum, post);
					node.path.add(postNodes.get(node.roomNum));
					while (node.path.size() <= 2) {
						if (random.nextBoolean() && MaxNode + 1 < post && node.roomNum != MaxNode) {
							node.path.add(postNodes.get(MaxNode));
							MaxNode++;
						} else
							break;
					}
				}
					
			}

		}
		}
		return false;
	}
}
