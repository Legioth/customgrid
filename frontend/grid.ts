import type { GridElement } from "@vaadin/vaadin-grid";

interface CustomGrid extends GridElement {
  $server: {
    requestRows: (page: number, pageSize: number) => Promise<unknown[]>;
  };
}

const inited = new WeakSet();

(window as any).initGrid = (grid: CustomGrid) => {
  if (inited.has(grid)) return;
  inited.add(grid);

  grid.addEventListener("active-item-changed", (event: any) => {
    grid.selectedItems = [event.detail.value];
  });

  grid.dataProvider = async (params, callback) => {
    const items = await grid.$server.requestRows(params.page, params.pageSize);
    callback(items, 10000);
  };
};
