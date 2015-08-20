package common;

public class Pager {

	/**
	 * ��ҳ
	 * @˵��������ҳ����ֱ�ӻ�ȡÿһҳ������
	 * @author Etwo
	 */
	
	/*
	 * ��ҳҪ�أ�
	 * 1����ҳ				first
	 * 2�����һҳ			last
	 * 3��ҳ����				pageCount
	 * 4���ܹ���ʾ�����ݼ�¼	rowCount
	 * 5��ÿҳ��ʾ�����ݼ�¼	pageRowCount
	 * 6����ǰҳ				curPage	
	 * 7������ÿһҳ�Ŀ�ʼ	start
	 * 8������ÿһҳ�Ľ���	end
	 */
	
	/**
	 * 1����ҳ				first
	 */
	private int first;
	
	/**
	 * 2�����һҳ			last
	 */
	private int last;
	
	/**
	 * 3��ҳ����				pageCount
	 */
	private int pageCount;
	
	/**
	 * 4���ܹ���ʾ�����ݼ�¼	totalCount
	 */
	private long totalCount;
	
	/**
	 * 5��ÿҳ��ʾ�����ݼ�¼	pageRowCount
	 */
	private int pageRowCount;
	
	/**
	 * 6����ǰҳ				curPage	
	 */
	private int curPage;
	
	/**
	 * 7������ÿһҳ�Ŀ�ʼ	start
	 */
	private int start;
	
	/**
	 * 8������ÿһҳ�Ľ���	end
	 */
	private int end;


	/**
	 * ���㲢�ó�ҳ����
	 * @return
	 */
	public int getPageCount() {
		this.pageCount = (int)Math.ceil((double)this.getTotalCount() / (double)this.getPageRowCount());
		return pageCount;
	}

	/**
	 * �õ��ܹ���ʾ�����ݼ�¼
	 * @return
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * �����ܹ���ʾ�����ݼ�¼
	 * @param rowCount
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * �õ�ÿҳ��ʾ�����ݼ�¼
	 * @return
	 */
	public int getPageRowCount() {
		return pageRowCount;
	}

	/**
	 * ����ÿҳ��ʾ�����ݼ�¼
	 * @param pageRowCount
	 */
	public void setPageRowCount(int pageRowCount) {
		this.pageRowCount = pageRowCount;
	}

	/**
	 * �õ���ǰҳ
	 * @return
	 */
	public int getCurPage() {
		if(curPage <= 0 ) {
			curPage = 1;
		} else if(curPage >= this.getPageCount()) {
			curPage = this.getPageCount();
		}
		return curPage;
	}

	/**
	 * ���õ�ǰҳ
	 * @param curPage
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	/**
	 * �õ�ÿҳ�Ŀ�ʼ��¼��
	 * @return
	 */
	public int getStart() {
		this.start = (this.getCurPage() - 1) * this.getPageRowCount();
		return start;
	}

	/**
	 * �õ�ÿҳ�Ľ�����¼��
	 * @return
	 */
	public int getEnd() {
		this.end = this.getPageRowCount();
		return end;
	}

	/**
	 * �õ���ҳ
	 * @return
	 */
	public int getFirst() {
		this.first = 1;
		return this.first;
	}
	
	/**
	 * �õ����һҳ
	 * @return
	 */
	public int getLast() {
		this.last = (int)this.getPageCount();
		return last;
	}
	
	/**
	 * ��һҳ
	 * @return
	 */
	public int previous() {
		return (this.getCurPage() > 1) ? this.getCurPage() - 1 : 1;
	}
	
	/**
	 * ��һҳ
	 * @return
	 */
	public int next() {
		return (this.getCurPage() < (int)this.getPageCount()) ? this.getCurPage() + 1 : (int)this.getPageCount();
	}
	
	/**
	 * �ж��Ƿ�����ҳ
	 * @return
	 */
	public boolean isFirst() {
		return (this.getCurPage() == 1) ? true : false;
	}
	
	/**
	 * �ж��Ƿ������һҳ
	 * @return
	 */
	public boolean isLast() {
		return (this.getCurPage() == this.getPageCount()) ? true : false;
	}
	
	/**
	 * �ͻ�����ʾ�Ĺ�����
	 */
	public String getToolBar(String url) {
        String str, temp;
        
        if (this.totalCount <= 0 || this.pageRowCount <= 0 || this.pageRowCount > this.totalCount) {
        	return "";
        }
        
        //�����ж�url���Ƿ���ڣ�
        if(url.indexOf("?") == -1) {
            temp = "?";
        } else {
            temp = "&";
        }
        
        str = "<form method='post' name='frmPage' action='" + url + "'> ";
        str += "<p id='page'>";
        str += "<span style='font-size: 12px; font-weight: bold;'>";
        //�ж��Ƿ�����ҳ
        if(isFirst()) {
        	str += "��ҳ ��һҳ&nbsp;";
        } else {
            str += "<a href='" + url + temp + "pg=" + this.getFirst() + "'>��ҳ</a>&nbsp;";
            str += "<a href='" + url + temp + "pg=" + this.previous() + "'>��һҳ</a>&nbsp;";
        }
        //�ж��Ƿ������һҳ
        if(isLast()) {
        	str += "��һҳ βҳ&nbsp;";
        } else {
            str += "<a href='" + url + temp + "pg=" + this.next() + "'>��һҳ</a>&nbsp;";
            str += "<a href='" + url + temp + "pg=" + this.getLast() + "'>βҳ</a>&nbsp;";
        }
        str += "&nbsp;��<b>" + this.totalCount + "</b>����¼&nbsp;";
        str += "&nbsp;ת��<select name='page' onChange=\"location='" + url + temp + "pg='+this.options[this.selectedIndex].value\">";
        
        for(int i = 1; i <= this.getPageCount(); i++) {
        	//�ж��Ƿ��ǵ�ǰҳ�����ǣ���Ĭ��Ϊѡ�е�ǰҳ
            if(i == this.getCurPage())
                str += "<option value='" + i + "' selected>��" + i + "ҳ</option>";
            else
                str += "<option value='" + i + "'>��" + i + "ҳ</option>";
        }
        str += "</select></span></p></form>";
        return str;
	}
}
