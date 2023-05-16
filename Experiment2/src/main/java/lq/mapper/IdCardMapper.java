package lq.mapper;

import lq.entity.IdCard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IdCardMapper {
    public int insertIdCard(String code);

    public IdCard findIdByCode(String code);

    public void delIdCardByid(Long idcard);
}
