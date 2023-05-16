package lq.mapper;

import lq.entity.IdCard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IdCardMapper {
    public IdCard findIdCardById(Long id);
    public int insertIdCard(String code);
    public IdCard findIdByCode(String code);

    public IdCard findIdCardByIds(Long id);
}
