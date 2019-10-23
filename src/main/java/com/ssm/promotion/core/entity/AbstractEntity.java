public abstract class AbstractEntity implements Serializable
{
	private static final long serialVersionUID = 66532814011080848L;
	
	private Long id;
	//创建时间
	private Date createDate;
	//修改时间
	private Date modifyDate;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getModifyDate()
	{
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate)
	{
		this.modifyDate = modifyDate;
	}
}
