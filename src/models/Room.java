package models;

public class Room {

	private Integer roomId;
	private Integer num;
	private boolean isFull;
	private Integer typeRoomId;

	public Room(Integer roomId, Integer num, boolean isFull, Integer typeRoomId) {
		super();
		this.roomId = roomId;
		this.num = num;
		this.isFull = isFull;
		this.typeRoomId = typeRoomId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public Integer getTypeRoomId() {
		return typeRoomId;
	}

	public void setTypeRoomId(Integer typeRoomId) {
		this.typeRoomId = typeRoomId;
	}

}