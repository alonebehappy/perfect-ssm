public interface BaseService<ID extends Serializable, T extends AbstractEntity<ID>> {

	int deleteByPrimaryKey(ID id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

	List<T> selectList(T record);

	PageInfo<T> getPageData(T record, int pageNum, int pageSize);
}
