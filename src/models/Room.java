package models;

public class Room {

	private Integer room_id;
	private Integer num;
	private boolean isFull;
	private Integer typeRoom_id;

	public Room(Integer room_id, Integer num, boolean isFull, Integer typeRoom_id) {
		super();
		this.room_id = room_id;
		this.num = num;
		this.isFull = isFull;
		this.typeRoom_id = typeRoom_id;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
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

	public Integer getTypeRoom_id() {
		return typeRoom_id;
	}

	public void setTypeRoom_id(Integer typeRoom_id) {
		this.typeRoom_id = typeRoom_id;
	}

}