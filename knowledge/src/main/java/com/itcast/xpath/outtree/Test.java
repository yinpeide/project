/**
 *ade
 *2015年10月22日
 * 
 */
package com.itcast.xpath.outtree;

/**
 * @author 尹培德
 * @time 2015年10月22日上午12:08:57
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	private static final Map<Long, Category> rendererMap = new TreeMap<Long, Category>();

	private static final Map<Long, Category> allElementMap = new TreeMap<Long, Category>();

	private static final List<Category> listMap = new ArrayList<Category>();

	public static void main(String[] args) throws Exception {

		SAXReader reader = new SAXReader();

		Document document = reader.read("data.xml");

		String xpath = "//category";

		List<Element> elementList = document.selectNodes(xpath);

		// -- ======================= 解析配置文件 =========================== --

		for (Element e : elementList) {

			Category c = new Category();

			c.setCreateTime(getTime(e.elementText("createTime")));

			c.setDescription(e.elementText("description"));

			c.setId(Long.parseLong(e.elementText("id")));

			c.setName(e.elementText("name"));

			c.setSort(Long.parseLong(e.elementText("sort")));

			c.setParentId(Long.parseLong(e.elementText("parentId")));

			listMap.add(c);

			allElementMap.put(c.getId(), c);

			// if ( c.getParentId() == 0 ) {

			// rendererMap.put(c.getId(), c);

			// }

		}

		// -- ==================== 组合对象之间的关系，形成树形结构 ===========================
		// --

		for (Category c : listMap) {

			Category pc = allElementMap.get(c.getParentId());

			if (pc == null) {

				rendererMap.put(c.getId(), c);

			} else {

				pc.getChildren().add(c);

			}

		}

		// -- ==================== 打印树形结构 =========================== --

		Iterator<Long> iter = rendererMap.keySet().iterator();

		while (iter.hasNext()) {

			Long id = iter.next();

			Category c = rendererMap.get(id);

			print(c, 0);

		}

	}

	private static void print(Category c, int deep) throws Exception {

		System.out.print("|--");

		for (int i = 0; i < deep; i++) {

			System.out.print("--");

		}

		System.out.println(c.getName());

		List<Category> cList = c.getChildren();

		for (Category cate : cList) {

			print(cate, deep + 1);

		}

	}

	private static Long getTime(String dacategoryring) throws Exception {

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

		return f.parse(dacategoryring).getTime();

	}

}
