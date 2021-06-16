import type { GridElement } from "@vaadin/vaadin-grid";

interface CustomGrid extends GridElement {
  $server: {
    requestRows: (page: number, pageSize: number) => void;
  };
}

const inited = new WeakSet();

(window as any).initGrid = (grid: CustomGrid) => {
  if (inited.has(grid)) return;
  inited.add(grid);

  grid.addEventListener("active-item-changed", (event: any) => {
    grid.selectedItems = [event.detail.value];
  });

  grid.dataProvider = (params, callback) => {
    grid.$server.requestRows(params.page, params.pageSize);
  };
};
