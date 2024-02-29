import { Component, OnInit } from '@angular/core';
import { Participant } from './components/model/participant.model';
import { RestService } from './services/rest.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  participants: Participant[] = [];

  constructor(private restService: RestService) { }

  ngOnInit() {
    this.getParticipants();
  }

  getParticipants() {
    this.restService.getData('/participants/all').subscribe((data) => {
      this.participants = data;
    });
  }
}
