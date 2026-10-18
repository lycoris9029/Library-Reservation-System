
package com.javabs.repository;

import com.javabs.domain.ColumnInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author 李寻欢
 * @date 2023-01-14
 */
public interface ColumnInfoRepository extends JpaRepository<ColumnInfo,Long> {

    /**
     * 查询表信息
     * @param tableName 表格名
     * @return 表信息
     */
    List<ColumnInfo> findByTableNameOrderByIdAsc(String tableName);
}
