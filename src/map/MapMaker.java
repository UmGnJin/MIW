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
	// 2차원 ArrayList 생성
	private ArrayList<Node> tempAL = null;

	final int firstFloorValue = 3;
	// 1층은 3개의 노드로 시작
	final int FloorMaxValue = 4;
	// 1개의 층은 1층을 제외하면 최대 4개의 노드로 이루어짐
	public final int floor = 14;
	// 층은 14개로 이루어짐

	public static int currentStageNum = 1;
	//전체 맵에 대한 방 번호

	Random random = new Random();

	public MapMaker() {
		loadMap();
	}
	
	//node 이너클래스. Node 클래스와 사실상 같은 역할을 함
	public class Node {
		public ArrayList<Node> path;
		//이어진 길이 담긴 AL
		
		int mapnumber;
		
		public String maptype;
		
		public String nodeName;
		//노드 이름. [층_방 번호]로 이루어짐
		
		int stagenumber;

		int roomNum;
		// 방 번호, 자신이 그 층에서 왼쪽에서부터 몇 번째 방에 있는지를 나타냄
		
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
			//층 만들기
		}
		connectNode();
		// 방 잇기
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
		roomName = roomName.concat("층_");
		roomName = roomName.concat(Integer.toString(roomNum+1));
		roomName = roomName.concat("번 방(");
		roomName = roomName.concat(RS + ")");
		return roomName;
	}


	// 방 출력
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
