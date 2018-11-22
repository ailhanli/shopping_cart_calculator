package com.ailhanli.domain;

public class Category {

	private String title;

	private Category parent;

	public Category(String title) {
		super();
		this.title = title;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public String getTitle() {
		return title;
	}

	public Category getParent() {
		return parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}