package br.com.russel.ey.heroes.endpoints;

public class ResourcePath {

	private String path;
	private Integer id;

	public ResourcePath(String path, Integer id) {
		super();
		this.path = path;
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public Integer getId() {
		return id;
	}

}
