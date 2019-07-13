import { Component, OnInit } from '@angular/core';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.scss']
})
export class TeamListComponent implements OnInit {

  constructor(private teamService: TeamService) { }
  teams = [];
  ngOnInit() {

    this.teams = this.teamService.getTeams();
    this.teamService.getTeamStream().subscribe((e) => {
      if (e !== '') {
        this.teams.push(e);
      }
    });
  }

}
