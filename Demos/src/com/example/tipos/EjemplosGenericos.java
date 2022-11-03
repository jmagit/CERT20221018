package com.example.tipos;

public class EjemplosGenericos {
	
	public static class Elemento<T> {
		private T key;
		private String value;

		public Elemento(T key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public T getKey() {
			return key;
		}

		public void setKey(T key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
//	public static class Elemento {
//		private Object key;
//		private String value;
//
//		public Elemento(Object key, String value) {
//			super();
//			this.key = key;
//			this.value = value;
//		}
//
//		public Object getKey() {
//			return key;
//		}
//
//		public void setKey(Object key) {
//			this.key = key;
//		}
//
//		public String getValue() {
//			return value;
//		}
//
//		public void setValue(String value) {
//			this.value = value;
//		}
//	}

	public static record Coordenada(int x, int y) {}
	public static record ElementoEntero(int key, String value) {}
	
	public static class ElementoInt {
		private int key;
		private String value;

		public ElementoInt(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}

	public static class ElementoChar {
		private char key;
		private String value;

		public ElementoChar(char key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public char getKey() {
			return key;
		}

		public void setKey(char key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
