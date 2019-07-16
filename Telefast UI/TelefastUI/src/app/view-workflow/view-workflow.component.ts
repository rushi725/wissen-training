import {ChangeDetectorRef, Component, Injectable, OnInit} from '@angular/core';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeFlattener, MatTreeNestedDataSource} from '@angular/material/tree';
// import {CollectionViewer, SelectionChange} from '@angular/cdk/collections';
import { BehaviorSubject } from 'rxjs';
// import {Observable} from 'rxjs/Observable';
// import {merge} from 'rxjs/observable/merge';
// import {map} from 'rxjs/operators/map';

/**
 * Node for game
 */


export class GameNode {
  children: BehaviorSubject<GameNode[]>;
  constructor(public item: string, children?: GameNode[], public parent?: GameNode) {
    this.children = new BehaviorSubject(children === undefined ? [] : children);
  }
}

/**
 * The list of games
 */
const TREE_DATA = [
  new GameNode('Simulation', [
    new GameNode('Factorio'),
    new GameNode('Oxygen not included'),
  ]),
  new GameNode('Indie', [
    new GameNode(`Don't Starve`, [
      new GameNode(`Region of Giants`),
      new GameNode(`Together`),
      new GameNode(`Shipwrecked`)
    ]),
    new GameNode('Terraria'),
    new GameNode('Starbound'),
    new GameNode('Dungeon of the Endless')
  ]),
  new GameNode('Action', [
    new GameNode('Overcooked')
  ]),
  new GameNode('Strategy', [
    new GameNode('Rise to ruins')
  ]),
  new GameNode('RPG', [
    new GameNode('Magicka', [
      new GameNode('Magicka 1'),
      new GameNode('Magicka 2')
    ])
  ])
];

@Component({
  selector: 'app-view-workflow',
  templateUrl: './view-workflow.component.html',
  styleUrls: ['./view-workflow.component.scss']
})
export class ViewWorkflowComponent implements OnInit {
  ngOnInit() {

  }


  recursive: boolean = false;
  levels = new Map<GameNode, number>();
  treeControl: NestedTreeControl<GameNode>;


  dataSource: MatTreeNestedDataSource<GameNode>;

  constructor(private changeDetectorRef: ChangeDetectorRef) {
  
    this.treeControl = new NestedTreeControl<GameNode>(this.getChildren);
    this.dataSource = new MatTreeNestedDataSource();
    this.dataSource.data = TREE_DATA;
  }
  getChildren = (node: GameNode) => {
    return node.children;
  };

  hasChildren = (index: number, node: GameNode) => {
    return node.children.value.length > 0;
  }


}
