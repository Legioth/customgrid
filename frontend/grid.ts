import type { GridElement } from "@vaadin/vaadin-grid";

const inited = new WeakSet();

(window as any).initGrid = (grid: GridElement) => {
  if (inited.has(grid)) return;
  inited.add(grid);

  grid.addEventListener("active-item-changed", (event: any) => {
    grid.selectedItems = [event.detail.value];
  });
};
